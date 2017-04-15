node {

   echo 'start'
   
    stage('Git') {
      git 'https://github.com/yurayuramen/try-ci.git'
    }
   
    checkout([$class: 'GitSCM',
      userRemoteConfigs: [[
        url: 'https://github.com/yurayuramen/try-ci.git'
      ]],
      branches: [[name: "origin/${githubSourceBranch}"]] // •Ï”“WŠJ‚Å‚«‚é‚æ‚¤‚É &quot; ‚ÅˆÍ‚¤‚±‚Æ
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
       parallel builds
    }
}