FROM openjdk:8
ADD target/order-product.jar order-product.jar
EXPOSE 80
ENTRYPOINT ["java","-jar", "order-product.jar"]
