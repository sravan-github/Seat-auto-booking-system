create database seat_db;
mvn spring-boot:run
![image](https://github.com/user-attachments/assets/3fadae11-ee58-4465-84d2-55c0e4c80325)
![image](https://github.com/user-attachments/assets/40043a6f-4733-4cfa-b77c-1a62cf7ac61d)
![image](https://github.com/user-attachments/assets/1afb5a9f-866f-4b52-9e08-fa8e2cc2a146)

kubectl apply -f secret.yml
kubectl apply -f configmap.yml
kubeclt apply -f springboot-deployment.yml

kubectl port-forward service/springboot-service 8080:80
