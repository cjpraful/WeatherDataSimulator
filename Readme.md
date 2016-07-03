# WeatherDataSimulator
# Description
This is a simulator for generating test data for weather prediction 

# Observation Input
Mean of Weather Data (eg Temperature,Humidity,Pressure, Condition etc ) collected from different Cities in US  
**Input File** : src/main/resourse/input/ObservedWeatherData.txt  
**Structure of input file data**:   
Cityname, IATACode, Continent, ContinentCode, DaysOfObservation, EndDateofObservation, MonthCode(January-1)| ProbabilyOfWetDayafterWetday| ProbabilityOfWetDayAfterDryDay| MeanTemp| StdDevnTemp| MeanPressure| StdDevnPressure| MeanHumidity| StdDevnHumidity| WeatherPredominantConditionSnowOrRain, <repeat till December> 

# Building the code 
**mvn clean install**

# Running the Project
java -jar target/WeatherDataSimulator-0.0.1-SNAPSHOT.jar <startDate> <endDate>
startDate (YYYY-MM-DD)  
endDate (YYYY-MM-DD)   
Eg : **java -jar target/WeatherDataSimulator-0.0.1-SNAPSHOT.jar 2016-02-15 2016-03-15**
    