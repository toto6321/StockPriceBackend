pipeline {
    agent any 
    
    tools {
        maven "M3"
    }
    
    stages {
        stage('Build') {
            steps {
                // Run Maven on a Unix.
                // cleanly build the Java application (without running any tests).
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') { 
            steps {
                sh './jenkins/scripts/deliver.sh' 
            }
        }
    }
    
}
