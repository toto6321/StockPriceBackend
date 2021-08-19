pipeline {
    agent {
        /*
            This image parameter downloads the maven:3.8.1-adoptopenjdk-11 Docker image (if it’s not already available on the machine), 
                and runs this image as a separate container.
            The Maven container becomes the agent that Jenkins uses to run the Pipeline project. 
        */ 
        docker {
            image 'maven:3.8.1-adoptopenjdk-11' 
            args '-v /root/.m2:/root/.m2' 
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
            }
        }
    }
}
