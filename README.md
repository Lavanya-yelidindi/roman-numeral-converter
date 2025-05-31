#Roman Numeral Converter
1) How to Run
	- Run the application using below command in your local

```bash
mvn spring-boot:run
```

2) How to Test

```bash
mvn test
```

3) A Spring Boot application with two endpoints:

	- `/api/toRoman` - Converts a number (1 to 1000) to Roman numeral.
	
	- `/api/toNumber` - Converts a Roman numeral back to a number.

# Usage

## Convert Number to Roman
Assumption : running in local with localhost:8080

**POST** `http://localhost:8080/api/toRoman`  
Body:

```json
{
  "number": 42
}
```

Response:

```json
{
  "roman": "XLII"
}
```

### Convert Roman to Number

**POST** `http://localhost:8080/api/toNumber`  
Body:

```json
{
  "roman": "XLII"
}
```
Response:

```json
{
  "number": 42
}
```

## Notes

- Input number must be between 1 and 1000.
- Roman numeral must be valid.

## Challenges

- Validating Roman numeral input correctly can be tricky without regex; added regex to validate.
