# Weather Data Processing System

## Overview

This project implements a real-time weather data processing system using Java. It fetches weather data from the OpenWeatherMap API, processes it, and provides summarized insights and alerts based on configurable thresholds.

## Components

1. **WeatherDataFetcher:** Retrieves weather data from OpenWeatherMap API.
2. **WeatherDataProcessor:** Processes and converts weather data.
3. **WeatherDataScheduler:** Manages data fetching intervals and scheduling.
4. **AlertManager:** Handles alert triggering based on configurable thresholds.
5. **WeatherDataStorage:** Stores and retrieves daily weather summaries.

## Installation

### Prerequisites

- **Java JDK 11 or higher**
- **Apache Maven**

### Steps

1. **Clone the Repository:**
    ```bash
    git clone https://github.com/yourusername/repositoryname.git
    cd repositoryname
    ```

2. **Install Dependencies:**
   Make sure you have Maven installed. Run the following command to install all necessary dependencies:
    ```bash
    mvn install
    ```

3. **Configuration:**
    - Create a `config.properties` file in the `src/main/resources` directory with the following content:
      ```properties
      api.key=your_api_key_here
      api.url=http://api.openweathermap.org/data/2.5/weather
      forecast.url=http://api.openweathermap.org/data/2.5/forecast
      update.interval=300000
      ```

4. **Run the Application:**
    - Use Maven to run the application:
      ```bash
      mvn exec:java -Dexec.mainClass="com.example.WeatherDataScheduler"
      ```

## Design Choices

- **Architecture:** Modular design with separate components for data fetching, processing, scheduling, and alerting.
- **Data Fetching:** `WeatherDataFetcher` handles API requests and retrieves weather data.
- **Data Processing:** `WeatherDataProcessor` converts temperatures and processes weather information.
- **Scheduling:** `WeatherDataScheduler` manages periodic data fetching using Java's `Timer`.
- **Alerting:** `AlertManager` triggers alerts based on user-configured temperature thresholds.
- **Storage:** `WeatherDataStorage` maintains daily summaries for historical analysis.

## Dependencies

- **Java Libraries:**
    - `org.apache.httpcomponents:httpclient:4.5.13` (for HTTP operations)
    - `com.google.code.gson:gson:2.8.9` (for JSON parsing)

- **Docker (Optional):**
    - **MySQL:** For database storage.
      ```bash
      docker run --name mysql -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=weatherdb -p 3306:3306 -d mysql:latest
      ```
    - **Redis:** If used for caching.
      ```bash
      docker run --name redis -p 6379:6379 -d redis:latest
      ```

## Testing

- **Unit Tests:** Located in the `src/test/java/com/example` directory.
- **Integration Tests:** Ensure end-to-end functionality of data processing and alerting.

## Contributing

Feel free to open issues or submit pull requests if you have suggestions or improvements.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

