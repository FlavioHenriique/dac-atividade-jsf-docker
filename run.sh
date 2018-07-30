sudo docker build -t dac/banco banco/

sudo docker run -d  -p 5433:5432 --name bancodac dac/banco
