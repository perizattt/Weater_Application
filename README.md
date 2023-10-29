### How to open a project?
In order for it to open, first copy this link, then open the terminal and write cd desktop (so that my project opens on your desktop) or the folder where you want to download my project. Then write git clone and past the link. And thus my project appeared on your desktop. Then you can open this folder in Intellij IDEA.
# Weater_Application

### WeatherApp class
The WeatherApp class is a mobile weather application. In the application, the user can enter the name of the city in the text field (cityTextField) and click the "Search" button (getWeatherButton) to obtain weather data for the specified city.
The application uses OpenWeatherMapClient to communicate with the OpenWeatherMap service to receive weather data. This data is then adapted using WeatherDataAdapter for convenient display in the mobile application in the MobileWeatherData object.
Weather data can then be incorporated into front-end applications, allowing the user to receive information about the current weather in the selected city.

### MobileWeatherData class
 The MobileWeatherData class is used to represent mobile weather data. It contains information about temperature and weather condition. The class allows you to set and retrieve temperature and weather conditions, and this data can be used to display weather information in a mobile application.

### WeatherDataWeatherAPI class
The WeatherDataWeatherAPI class represents weather data obtained from a WeatherAPI source. It contains information about temperature (temp) and current weather condition (currentCondition). The class allows you to get and set temperature and weather conditions, and this data can be used, for example, to display the current weather in an application.

### WeatherDataOpenWeather class
The WeatherDataOpenWeather class represents weather data from an OpenWeather source. It contains information about temperature and weather conditions. The class allows you to set and retrieve temperature and weather conditions. This data can be used, for example, to present the current weather in an application.

### OpenWeatherMapClient class
The OpenWeatherMapClient class is used to retrieve weather data from the OpenWeatherMap API for a specified city. The class constructor accepts the API key and stores it. The getWeatherData method makes an HTTP request to the API, retrieves the weather data for the specified city, parses the JSON response, and returns a WeatherDataOpenWeather object representing the temperature and weather state. In case of error, returns null.

### WeatherDataAdapter class 
This WeatherDataAdapter class implements the "Adapter" pattern. It provides a common WeatherData interface that combines weather data from two sources: WeatherDataOpenWeather and WeatherDataWeatherAPI. The class adapts data from these sources to expose it through the common WeatherData interface.
The getTemperature and getCondition methods allow you to get temperature and weather conditions through a common interface, hiding the differences in data structure between WeatherDataOpenWeather and WeatherDataWeatherAPI. The adaptFromOpenWeather method adapts the data from WeatherDataOpenWeather into a MobileWeatherData object to make it easier to work with the data.
