[[ ! -a /var/jenkins_home ]] && mkdir -p /var/jenkins_home
docker run -itd --name ct-jenkins --network=ct-network -h jenkins -p 8081:8080 -p 50000:50000 -u root -v /var/jenkins_home:/var/jenkins_home jenkins
