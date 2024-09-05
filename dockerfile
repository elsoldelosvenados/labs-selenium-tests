# Usar una imagen base de Ubuntu para mayor compatibilidad con ARM
FROM ubuntu:20.04

# Instalar dependencias necesarias
RUN apt-get update && apt-get install -y wget gnupg unzip curl openjdk-17-jdk

# Instalar Google Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - && \
    echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" > /etc/apt/sources.list.d/google-chrome.list && \
    apt-get update && apt-get install -y google-chrome-stable

# Instalar ChromeDriver
RUN CHROME_DRIVER_VERSION=$(curl -sS chromedriver.storage.googleapis.com/LATEST_RELEASE) && \
    wget -N https://chromedriver.storage.googleapis.com/$CHROME_DRIVER_VERSION/chromedriver_linux64.zip && \
    unzip chromedriver_linux64.zip && \
    mv chromedriver /usr/local/bin/chromedriver && \
    chmod +x /usr/local/bin/chromedriver && \
    rm chromedriver_linux64.zip

# Instalar Gradle
RUN wget https://services.gradle.org/distributions/gradle-8.3-bin.zip && \
    unzip gradle-8.3-bin.zip && \
    mv gradle-8.3 /opt/gradle && \
    ln -s /opt/gradle/bin/gradle /usr/bin/gradle && \
    rm gradle-8.3-bin.zip

# Configurar variables de entorno para ChromeDriver
ENV PATH /usr/local/bin:$PATH
ENV CHROME_BIN=/usr/bin/google-chrome
ENV CHROME_DRIVER=/usr/local/bin/chromedriver

# Configurar el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos del proyecto al contenedor
COPY . .

# Comando para ejecutar las pruebas al iniciar el contenedor
CMD ["gradle", "test", "--info", "--tests", "runners.RunCucumberTest"]
