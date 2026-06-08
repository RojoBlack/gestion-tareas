# Sistema de Gestión de Tareas

API REST backend construida con **Java 17 + Spring Boot 3** y **PostgreSQL**. Permite gestionar tareas organizadas por categorías, con estados de progreso, fechas de vencimiento y filtros. Documentación interactiva disponible vía Swagger UI.

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot_3.3-6DB33F?style=flat-square&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-4169E1?style=flat-square&logo=postgresql&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=flat-square&logo=gradle&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger_UI-85EA2D?style=flat-square&logo=swagger&logoColor=black)

---

## Características

- CRUD completo para **Tareas** y **Categorías**
- Estados de tarea: `PENDIENTE`, `EN_PROGRESO`, `COMPLETADA`
- Filtrado de tareas por **estado** y por **categoría**
- Ordenamiento de tareas por **fecha de vencimiento**
- Relación entre entidades: cada tarea pertenece a una categoría
- Documentación interactiva con **Swagger UI** en `/swagger-ui.html`
- Arquitectura por capas: `controller → service → repository → entity`

---

## Tecnologías

| Capa | Tecnología |
|---|---|
| Lenguaje | Java 17 |
| Framework | Spring Boot 3.3.2 |
| Persistencia | Spring Data JPA + Hibernate |
| Base de datos | PostgreSQL |
| Build tool | Gradle |
| Boilerplate | Lombok |
| Documentación | Springdoc OpenAPI (Swagger UI) |

---

## Requisitos previos

- Java 17+
- PostgreSQL corriendo localmente
- Gradle (o usar el wrapper incluido `./gradlew`)

---

## Instalación y configuración

**1. Clonar el repositorio**

```bash
git clone https://github.com/RojoBlack/gestion-tareas.git
cd gestion-tareas
```

**2. Crear la base de datos en PostgreSQL**

```sql
CREATE DATABASE tareas_db;
```

**3. Configurar variables de entorno**

Copia el archivo de ejemplo y completa tus credenciales:

```bash
cp .env.example .env
```

```env
DB_URL=jdbc:postgresql://localhost:5432/tareas_db
DB_USERNAME=tu_usuario
DB_PASSWORD=tu_password
```

**4. Ejecutar la aplicación**

```bash
./gradlew bootRun
```

La API estará disponible en `http://localhost:8080`.

> Las tablas se crean automáticamente al iniciar gracias a `spring.jpa.hibernate.ddl-auto=update`.

---

## Documentación de la API

Con la aplicación corriendo, accede a la documentación interactiva:

```
http://localhost:8080/swagger-ui.html
```

---

## Endpoints

### Tareas — `/api/tareas`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/tareas` | Listar todas las tareas |
| `POST` | `/api/tareas` | Crear una tarea |
| `GET` | `/api/tareas/{id}` | Obtener tarea por ID |
| `PUT` | `/api/tareas/{id}` | Actualizar tarea |
| `DELETE` | `/api/tareas/{id}` | Eliminar tarea |
| `GET` | `/api/tareas/estado/{estado}` | Filtrar por estado |
| `GET` | `/api/tareas/categoria/{nombre}` | Filtrar por categoría |
| `GET` | `/api/tareas/ordenar/fecha` | Ordenar por fecha de vencimiento |

**Estados válidos:** `PENDIENTE` · `EN_PROGRESO` · `COMPLETADA`

### Categorías — `/api/categorias`

| Método | Endpoint | Descripción |
|---|---|---|
| `GET` | `/api/categorias` | Listar todas las categorías |
| `POST` | `/api/categorias` | Crear una categoría |
| `GET` | `/api/categorias/{id}` | Obtener categoría por ID |
| `PUT` | `/api/categorias/{id}` | Actualizar categoría |
| `DELETE` | `/api/categorias/{id}` | Eliminar categoría |

---

## Ejemplos de uso

**Crear una categoría**

```bash
curl -X POST http://localhost:8080/api/categorias \
  -H "Content-Type: application/json" \
  -d '{"nombre": "Trabajo"}'
```

**Crear una tarea**

```bash
curl -X POST http://localhost:8080/api/tareas \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Preparar informe mensual",
    "descripcion": "Revisar métricas del mes",
    "estado": "PENDIENTE",
    "fechaVencimiento": "2025-12-31",
    "categoria": { "id": 1 }
  }'
```

**Filtrar tareas por estado**

```bash
curl http://localhost:8080/api/tareas/estado/EN_PROGRESO
```

---

## Estructura del proyecto

```
src/
└── main/
    ├── java/com/tareas/gestiontareas/
    │   ├── controller/        # Endpoints REST
    │   │   ├── TareaController.java
    │   │   ├── CategoriaController.java
    │   │   └── HomeController.java
    │   ├── entity/            # Modelos JPA
    │   │   ├── Tarea.java
    │   │   └── Categoria.java
    │   ├── repository/        # Interfaces Spring Data
    │   ├── service/           # Lógica de negocio
    │   └── GestionTareasApplication.java
    └── resources/
        └── application.properties
```

---

## Autor

**René Alarcón Sandoval** — [GitHub](https://github.com/RojoBlack) · [LinkedIn](https://linkedin.com/in/rene-alarcon-sandoval) · [Portfolio](https://mi-portafolio-zeta-seven.vercel.app)
