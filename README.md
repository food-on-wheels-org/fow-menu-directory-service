# Menu Directory Service

Manages menu items associated with restaurants in the Food-on-Wheels platform.

---

## Overview
- Spring Boot REST API built using Spring Boot and **AWS RDS (MySQL)**.
- Endpoints for user management.
- Integrates with the **restaurant-listing-service** for linked data.  
- Exposed through Ingress and AWS ALB.
- Deployed on AWS EKS via ArgoCD.

---

## Tech Stack
Spring Boot, Spring Data JPA, AWS RDS, MySQL, Eureka Client, Docker, Kubernetes, Jenkins, SonarQube, ArgoCD

---

## Endpoints
| Method | Endpoint | Description |
|---------|-----------|-------------|
| GET | `/fetchRestaurantAndMenuById/{restaurantId}` | Get menu associated with a selected restaurant |
| POST | `/addItemToMenu` | Create menu item |


## Future additions
- Update Menu Item
- Remove Menu Item


---

## Deployment
Built and analyzed through Jenkins and SonarQube.
Docker image: `tejassrivathsa/menu-directory-service:latest`  .
Deployed to AWS EKS using ArgoCD.
