FROM alpine:3.11

RUN apk add --no-cache openssh-client ansible git sshpass
RUN pip3 install docker

COPY ./ansible /ansible

WORKDIR /ansible

CMD ["tail", "-f", "/dev/null"]
