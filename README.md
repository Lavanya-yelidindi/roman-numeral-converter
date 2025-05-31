# Roman Numeral Converter

## 1) About the Application

A Spring Boot application with two endpoints:

- `POST /api/toRoman` – Converts a number (1 to 1000) to a Roman numeral.
- `POST /api/toNumber` – Converts a Roman numeral back to a number.

## 2) Deployed in Render

The application is deployed on Render and available at a public URL.

---

# Usage

## ✅ USING PUBLIC URL

### 🔁 Convert Number to Roman

**POST**  
`https://roman-numeral-converter-cjbg.onrender.com/api/toRoman`

**Body:**
```json
{
  "number": 42
}
```

**Response:**
```json
{
  "roman": "XLII"
}
```

---

### 🔁 Convert Roman to Number

**POST**  
`https://roman-numeral-converter-cjbg.onrender.com/api/toNumber`

**Body:**
```json
{
  "roman": "XLII"
}
```

**Response:**
```json
{
  "number": 42
}
```

---

## 💻 USING LOCAL
## 1) How to Run
Run the application using the below command in your local environment:

```bash
mvn spring-boot:run
```

## 2) How to Test

```bash
mvn test
```
## 💻 USING LOCAL URL

Assumption: Application is running locally at `http://localhost:8080`

### 🔁 Convert Number to Roman

**POST**  
`http://localhost:8080/api/toRoman`

**Body:**
```json
{
  "number": 42
}
```

**Response:**
```json
{
  "roman": "XLII"
}
```

---

### 🔁 Convert Roman to Number

**POST**  
`http://localhost:8080/api/toNumber`

**Body:**
```json
{
  "roman": "XLII"
}
```

**Response:**
```json
{
  "number": 42
}
```

---

## Notes

- Input number must be between 1 and 1000.
- Roman numeral must be valid and follow standard notation.

## Challenges

- Validating Roman numeral input correctly can be tricky without regex.
- Added regex-based validation to handle correctness and prevent invalid formats.


---

## 🚫 Error Scenarios

### ❌ Number Above 1000

**POST**  
`http://localhost:8080/api/toRoman`

**Body:**
```json
{
  "number": 1500
}
```

**Response:**
```json
{
  "error": "Number must be between 1 and 1000"
}
```

---

### ❌ Roman Numeral Representing Value Above 1000

**POST**  
`http://localhost:8080/api/toNumber`

**Body:**
```json
{
  "roman": "MCC"
}
```

**Response:**
```json
{
  "error": "Roman numeral must represent a number between I and M"
}
```
