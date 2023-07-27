<template>
  <div class="flex space-x-10 border-t-2 border-grey-500 py-8">
    <div class="flex items-center">
      <fa :icon="['fas', 'wind']" />
      <div class="pl-1">
        {{ otherWeatherInfos.wind }}
      </div>
    </div>
    <div class="flex items-center">
      <fa :icon="['fas', 'droplet']" />
      <div class="pl-1">%{{ otherWeatherInfos.humidity }}</div>
    </div>
    <div class="flex items-center">
      <fa :icon="['fas', 'cloud']" />
      <div class="pl-1">%{{ otherWeatherInfos.clouds }}</div>
    </div>
  </div>
</template>

<script setup>
defineProps({
  otherWeatherInfos: Object,
});
</script>
