pipeline {
agent any
  stages{
    steps('Build'){
      sh '/Applications/apache-maven-3.6.0/bin mvn clean install'
    }
  }
  stages{
    steps('Test'){
      sh '/Applications/apache-maven-3.6.0/bin mvn clean test'
    }
  }
}
