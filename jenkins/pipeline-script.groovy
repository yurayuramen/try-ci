node {

   echo 'start'
   
    stage('Git') {
      git 'https://github.com/yurayuramen/try-ci.git'
    }
   
    checkout([$class: 'GitSCM',
      userRemoteConfigs: [[
        url: 'https://github.com/yurayuramen/try-ci.git'
      ]],
      branches: [[name: "origin/${githubSourceBranch}"]] // 変数展開できるように &quot; で囲うこと
    ])
   
   stage('Build') {
        def builds = [:]
        builds['scala'] = {
           // assumes you have the sbt plugin installed and created an sbt installation named &apos;sbt-0.13.13&apos;
           // sh "${tool name: 'sbt-0.13.13', type: '/usr/local/sbt/bin/sbt compile dist"
           sh '/usr/local/sbt/bin/sbt compile dist'
        }
        builds['frontend'] = {
           echo 'building the frontend';
        }
        builds['docker'] = {
           //sh '/usr/local/bin/docker-compose build rails';
           sh '/usr/local/bin/docker build -t tryci_rails ror_rails_adm'
        }
       parallel builds
    }
}
