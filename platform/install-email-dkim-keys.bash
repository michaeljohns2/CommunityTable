docker run --rm \
  -v "$(pwd)/config":/tmp/docker-mailserver \
  -ti tvial/docker-mailserver:latest generate-dkim-config
