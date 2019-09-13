pipeline {
agent any
  stage {
    steps('Build'){
      sh '/Applications/apache-maven-3.6.0/bin mvn clean install'
    }
  }
  stage {
    steps('Test'){
      sh '/Applications/apache-maven-3.6.0/bin mvn clean test'
    }
  }
}
