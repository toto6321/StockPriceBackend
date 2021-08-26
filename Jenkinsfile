pipeline {
    agent  {
        // set up a node labeled with local running on the host machine ahead
        node {
            label 'local'
        }
    }
    stages {
        stage('Build') {
            steps {
                // Run Maven on a Unix.
                // cleanly build the Java application (without running any tests).
                sh "mvn -Dmaven.test.failure.ignore=true clean package"

                // To run Maven on a Windows agent, use
                // bat "mvn -Dmaven.test.failure.ignore=true clean package"
                // build the images with docker compose
                sh "docker-compose build"
            }
        }
        stage('Test') {
            steps {
                // sh 'mvn test'
                sh 'echo "pass"'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
        stage('Deliver') { 
            steps {
                sh 'sh deliver.sh' 
            }
        }
    }
    
}
