pipeline {
    agent {
        docker {
            image 'arm32v7/maven'
            args '-v /root/.m2:/root/.m2 -u root'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
    }
}