# EppClient

A Java-based client for interacting with EPP (Extensible Provisioning Protocol) servers to manage domains and contact information.

## Overview
The `EppClient` application provides a convenient way to communicate with an EPP server by sending XML-based requests and processing the responses. It supports core functionalities such as:
- **Authentication**: Logging into the EPP server using credentials.
- **Contact Management**: Retrieving and parsing detailed contact information from the registrar's database.
- **XML Handling**: Seamless integration with Jsoup for parsing complex XML structures returned by the EPP server.

## Project Structure
- `src/eppclient`: Contains the primary source code for the client.
    - `EppClient.java`: The core engine that handles HTTP connections, XML submission, and basic EPP logic.
    - `contact/`: A package dedicated to handling contact-related operations (fetching, parsing, and mapping).
- `src/epp-guide-examples-v4.3`: Contains a collection of sample EPP request and response files, along with the relevant XSD schemas, useful as reference material for standard EPP transactions.

## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- Ant build tool
- Maven/Gradle are not required but some dependencies like Jsoup might need to be included in the classpath during compilation.

### Build and Run
This project uses Apache Ant for building. Use the following commands:

```bash
# To clean the previous builds
ant clean

# To compile the project
ant compile

# To run the main application (if configured in build.xml)
ant run
```

## Example Usage
The `Main` class provides a simple entry point to demonstrate functionality:

```java
public class Main {
    public static void main(String[] args) throws Exception {
        EppClient client = new EppClient();
        client.login();
        
        EppContactInfo contactInfo = client.contactInfo("nektarios");
        System.out.println("Contact ID: " + contactInfo.getContactId());
    }
}
```

## License
Standard open-source license applies (refer to `manifest.mf` or project policy).
