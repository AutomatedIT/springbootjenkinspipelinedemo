node('master'){
  sh './gradlew clean build'
  sh 'cp ./build/libs/cicdjenkins*.jar .'
  sh 'cp cicdjenkins*.jar /app.jar'
  sh '/usr/bin/java -jar -Dspring.profiles.active=test -Dserver.port=80 /app.jar'
}
