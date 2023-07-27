<template>
  <div class="flex flex-col items-center space-y-10 mt-5 pb-6 capitalize">
    <div>
      {{ $t("feelsLikeTempTitle") }}
      {{ Math.ceil(temperatureInfos?.feelsLike) }}°
    </div>
    <div>
      <div
        class="rounded-full relative z-0 bg-slate-50 border-2 border-slate-200 shadow-2xl opacity-75 p-8"
      >
        <transition name="fade">
          <img
            class="absolute right-8 bottom-8 z-10"
            :src="icon"
            :key="temperatureInfos?.temperature"
          />
        </transition>

        {{ Math.ceil(temperatureInfos?.temperature) }}°
      </div>
    </div>

    <div>{{ temperatureInfos?.weather?.at(0)?.description }}</div>
  </div>
</template>

<script setup>
import { computed } from "vue";

const props = defineProps({
  temperatureInfos: Object,
});

const icon = computed(() => {
  return `https://openweathermap.org/img/wn/${
    props.temperatureInfos?.weather?.at(0)?.icon
  }@2x.png`;
});
</script>

<style>
.fade-enter-from {
  opacity: 0;
  transform: translateX(-100%);
}

.fade-enter-to {
  opacity: 1;
  transition: all 1s ease-in-out;
}

.fade-leave-from {
  opacity: 1;
  transform: translateX(0);
}
.fade-leave-to {
  opacity: 0;
  transition: all 1s ease-in-out;
  transform: translateX(100%);
}
</style>
