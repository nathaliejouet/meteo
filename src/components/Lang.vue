<template>
  <div class="flex justify-end w-full">
    <select
      v-model="$i18n.locale"
      class="block w-16 p-2 mb-6 text-sm rounded-lg bg-gray-50 cursor-pointer"
    >
      <option v-for="item in lang" :value="item">
        {{ item.toUpperCase() }}
      </option>
    </select>
  </div>
</template>

<script setup>
import { computed } from "vue";
import Lang from "../enums/Lang.js";

const lang = computed(() => {
  return Object.values(Lang);
});
</script>
