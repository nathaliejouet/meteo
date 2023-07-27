<template>
  <div
    class="flex flex-col items-center space-y-10 bg-slate-50 rounded-lg w-80 h-4/6 p-8"
  >
    <Lang />
    <Search v-model="city" />
    <div v-if="!error">
      <Temperature :temperatureInfos="temperatureInfos" v-if="weatherInfos" />
      <Informations :otherWeatherInfos="otherWeatherInfos" />
    </div>

    <div v-else class="normal-case text-center">{{ error }}</div>
  </div>
</template>

<script setup>
import { ref, computed } from "vue";
import { useI18n } from "vue-i18n";
import Search from "./Search.vue";
import Temperature from "./Temperature.vue";
import Informations from "./Informations.vue";
import Lang from "./Lang.vue";
import useGetCurrentWeather from "../composables/useGetCurrentWeather.js";

const { locale } = useI18n();

const city = ref("Nantes");

const { weatherInfos, error } = await useGetCurrentWeather(locale, city);

const temperatureInfos = computed(() => {
  return {
    temperature: weatherInfos?.value?.main?.temp,
    feelsLike: weatherInfos?.value?.main?.feels_like,
    weather: weatherInfos?.value?.weather,
  };
});

const otherWeatherInfos = computed(() => {
  return {
    wind: weatherInfos?.value?.wind?.speed,
    humidity: weatherInfos?.value?.main?.humidity,
    clouds: weatherInfos?.value?.clouds?.all,
  };
});
</script>
