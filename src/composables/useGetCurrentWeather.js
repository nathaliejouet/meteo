import { ref, toValue, watchEffect } from "vue";
import weatherService from "../services/weather.service";
import { i18n } from "../i18n";

export default async function useGetCurrentWeather(locale, city) {
  const { t } = i18n.global;
  const weatherInfos = ref(null);
  const error = ref("");

  watchEffect(async () => {
    error.value = "";

    const response = await weatherService.getCurrentWeatherByCity(
      toValue(locale),
      toValue(city)
    );
    const json = await response.json();

    if (json.cod == "200") {
      weatherInfos.value = json;
    } else if (json.cod == "400") {
      error.value = t("errors.badRequest");
    } else if ((json.cod = "404")) {
      error.value = t("errors.notFound");
    } else {
      error.value = t("errors.otherError");
    }
  });

  return { weatherInfos, error };
}
