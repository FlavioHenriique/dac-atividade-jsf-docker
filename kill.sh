sudo docker kill $(docker container ls -a -q)
sudo docker rmi -f $(docker image ls dac/* -q)

sudo docker rm -f $(sudo docker ps -aq --filter name=bancodac)
sudo docker rm -f $(sudo docker ps -aq --filter name=app)
