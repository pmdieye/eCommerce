pipeline{
agent any
  stages {
    stage('Build'){
     steps{
        sh '/Applications/apache-maven-3.6.0/bin mvn clean install'
    }
   }
    stage('Test'){
      steps{
        sh '/Applications/apache-maven-3.6.0/bin mvn clean test'
      }
   }
  }
}
