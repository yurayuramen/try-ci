node {

  try
  {
   /*
    stage('Git') {
      git url: 'https://github.com/yurayuramen/try-ci.git', branch: "origin/${githubSourceBranch}"
    }
    */
    stage('Git') {
    checkout([$class: 'GitSCM',
      userRemoteConfigs: [[
        url: 'https://github.com/yurayuramen/try-ci.git'
      ]],
      branches: [[name: "origin/${githubSourceBranch}"]] // 変数展開できるように &quot; で囲うこと
    ])
    }
   stage('Build') {
        def builds = [:]
        builds['scala'] = {
           // assumes you have the sbt plugin installed and created an sbt installation named &apos;sbt-0.13.13&apos;
           // sh "${tool name: 'sbt-0.13.13', type: '/usr/local/sbt/bin/sbt compile dist"
           sh '/usr/local/sbt/bin/sbt compile'
        }

        builds['mysql-start'] = {
          sh 'docker rm -f mysql & sleep 2 && docker run -d -e "MYSQL_ROOT_PASSWORD=passwd" --rm --name mysql -p "3306:3306" mysql:5.6'
        }

        builds['docker'] = {
           //sh '/usr/local/bin/docker-compose build rails';
           sh 'docker build -t tryci_rails ror_rails_adm'
        }

        parallel builds
    }

    stage('migrate')
    {
        sh """docker run --link mysql --rm --name ror_init tryci_rails rails db:create && \
        docker run --link mysql --rm --name ror_init tryci_rails rails db:migrate && \
        docker run --link mysql --rm --name ror_init tryci_rails rails db:seed """ 
        //TODO テストrun!!
    }

    stage('test'){
      sh '/usr/local/sbt/bin/sbt test'
    }
  }
  finally
  {
    sh 'docker rm -f mysql'
  }
}
