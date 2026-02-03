## Automation test framework for Funda API

### Description
API test automation framework written in Java 21.  
Used for validating backend APIs via automated tests.

## Requirements
- Java 21
- Maven 3.9+

## Install SDKMAN and Java 21
```bash
curl -s "https://get.sdkman.io" | bash \
  && source "$HOME/.sdkman/bin/sdkman-init.sh" \
  && sdk install java 21.0.2-tem \
  && sdk use java 21.0.2-tem \
  && java -version
```

## To run tests
```bash

mvn clean test
```

## Test Coverage and Approach
The tests in this project are focused on the most critical user flows that can be validated without
entity creation or authentication.

### Covered flows
1. Search for properties:
    - new listings
    - properties for sale
    - new building projects
2. Contact the agency flow
3. Search for an agency by address

### Bugs found during test implementation
While implementing the automated tests, several issues were identified in the API behavior.
These issues were covered with additional smoke tests to ensure early detection of regressions.

### Implementation notes
- Tests are written around real user scenarios and critical business flows
- API interactions that require authentication or entity creation are intentionally excluded
- Additional comments were added directly in the code to explain:
    - why a specific approach was chosen
    - how edge cases and unexpected responses are handled
