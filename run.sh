sudo docker build -t dac/banco banco/
sudo docker build -t dac/app .

sudo docker run -d  -p 5433:5432 --name bancodac dac/banco
sudo docker run -p 8081:8080 --link bancodac:host-banco dac/app
