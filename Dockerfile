FROM openjdk:8
LABEL autorh="avasdream"
ENV SCALA_VERSION 2.11.8
ENV SBT_VERSION 0.13.17
RUN mkdir ~/src
RUN \
  curl -fsL https://downloads.typesafe.com/scala/$SCALA_VERSION/scala-$SCALA_VERSION.tgz | tar xfz - -C /root/ && \
  echo >> /root/.bashrc && \
  echo "export PATH=~/scala-$SCALA_VERSION/bin:$PATH" >> /root/.bashrc


RUN \
  curl -L -o sbt-$SBT_VERSION.deb https://dl.bintray.com/sbt/debian/sbt-$SBT_VERSION.deb && \
  dpkg -i sbt-$SBT_VERSION.deb && \
  rm sbt-$SBT_VERSION.deb && \
  apt-get update && \
  apt-get install sbt && \
  sbt sbtVersion 
ADD build.sbt /root/src/build.sbt
RUN cd /root/src && sbt compile
RUN echo 'alias e=exit' >> ~/.bashrc
RUN echo 'alias c=clear' >> ~/.bashrc
WORKDIR /root/src
CMD sbt run