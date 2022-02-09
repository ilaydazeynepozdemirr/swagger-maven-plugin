withEnv(["JENKINS_MACHINE=${MACHINE_TYPE}"]){
node(env.JENKINS_MACHINE) {
	stage('Preparation') {
		cleanWs()
		scmVars = checkout scm
		mvnHome = '/usr/share/maven'
	}
	stage('maven build') {
        sh "'${mvnHome}/bin/mvn' clean install"
	}
}
}


