FROM ruby:2.3
ENV LANG C.UTF-8

RUN apt-get update && \
    apt-get install -y nodejs mysql-client npm --no-install-recommends && \
    rm -rf /var/lib/apt/lists/* && \
    mkdir -p /usr/src/app
WORKDIR /usr/src/app

COPY Gemfile /usr/src/app/
COPY Gemfile.lock /usr/src/app/
RUN bundle install 
#RUN bundle install --path vendor/bundle

COPY . /usr/src/app

ENV LANG ja_JP.UTF-8
RUN ln -sf  /usr/share/zoneinfo/Asia/Tokyo /etc/localtime
# ENV TZ Asia/Tokyo

EXPOSE 3000 1234 26162

CMD ["./bin/rails", "server", "-b", "0.0.0.0"]
