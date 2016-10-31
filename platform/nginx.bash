[[ ! -a /etc/nginx ]] && mkdir -p /etc/nginx
docker run -itd --name ct-nginx --network=ct-network -h nginx -p 80:80 -v /etc/nginx/conf.d:/etc/nginx/conf.d nginx
