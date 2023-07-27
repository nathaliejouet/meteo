export default {
  async getCurrentWeatherByCity(lang = "fr", city) {
    return await fetch(
      `https://api.openweathermap.org/data/2.5/weather?q=${city}&units=metric&lang=${lang}&appid=${
        import.meta.env.VITE_API_KEY
      }`
    );
  },
};
