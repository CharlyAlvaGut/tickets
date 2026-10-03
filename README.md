# 🎫 Portal de Servicios IPN
### Sistema de Gestión de Órdenes de Servicio (Tickets)

![Java](https://img.shields.io/badge/Java-SpringBoot-6B1228?style=for-the-badge&logo=springboot)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-Template-6B1228?style=for-the-badge&logo=thymeleaf)
![MySQL](https://img.shields.io/badge/MySQL-Database-6B1228?style=for-the-badge&logo=mysql)
![Bootstrap](https://img.shields.io/badge/Bootstrap-4-6B1228?style=for-the-badge&logo=bootstrap)

---

## Descripción
Sistema web desarrollado para el **Instituto Politécnico Nacional** que permite levantar, 
asignar y dar seguimiento a órdenes de servicio (tickets) de manera eficiente y centralizada.

---

## Funcionalidades
- Autenticación por correo institucional
- Creación y seguimiento de tickets
- Adjuntar documentos a las órdenes
- Asignación de tickets por área y usuario
- Reportes y consultas
- Notificaciones por correo electrónico
- Control de acceso por roles (Admin, Staff, Usuario)

---

## Tecnologías
| Capa | Tecnología |
|------|-----------|
| Backend | Java 17 + Spring Boot |
| Frontend | Thymeleaf + Bootstrap 4 |
| Base de datos | MariaDB |
| Seguridad | Spring Security |
| Correo | Spring Mail (SMTP) |

---

## Instalación

### Requisitos previos
- Java 17+
- Maven
- MySQL 8+

### Pasos
1. Clona el repositorio
   \`\`\`bash
   git clone https://github.com/tu-usuario/portal-servicios-ipn.git
   \`\`\`
2. Configura tu base de datos en `application.properties`
   \`\`\`properties
   spring.datasource.url=jdbc:mysql://localhost:3306/tu_bd
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_password
   \`\`\`
3. Ejecuta el proyecto
   \`\`\`bash
   mvn spring-boot:run
   \`\`\`

---

## Autores
Desarrollado por **José Carlos Alvarado Gutiérrez** y **Ricardo San Agustín Alcivar** — Estudiantes del Instituto Politécnico Nacional  
Escuela Superior de Cómputo (ESCOM)

---

> Instituto Politécnico Nacional · Portal de Servicios IPN
