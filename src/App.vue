<template>
  <div class="flex items-center justify-center h-screen">
    <Suspense>
      <Content />
      <template #fallback>Loading</template>
    </Suspense>
  </div>
</template>

<script setup>
import Content from "./components/Content.vue";
</script>
