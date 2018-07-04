node('localhost'){
  stage('Clean up workspace'){
    step([$class: 'WsCleanup'])    
  }
  
  stage('Check-out'){
    try{
        
        def gitURL = "https://github.com/AutomatedIT/springbootjenkinspipelinedemo"
        def credentials = "jp_github"
        checkout([$class: 'GitSCM', branches: [[name: '*/master']], userRemoteConfigs: [[credentialsId: credentials, url: gitURL]]])
        
    }catch (Exception e){
        throw e
    }
  }
  
  stage('Build payload'){
      sh './gradlew clean build'
      sh 'mv $WORKSPACE/build/libs/cicdjenkins*.jar $WORKSPACE/app.jar'
  }
  
  stage('Build Dockerized App'){
    sh 'docker build -t automateditsolutions/jenkins_demo_springbboot_app:latest .'
  }
  
  stage('Run Dockerized App'){
    sh 'docker run -d --name jenkins_demo_springbboot_app -p 90:8080 automateditsolutions/jenkins_demo_springbboot_app:latest'
  }
}
