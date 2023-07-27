<template>
  <input
    type="text"
    :value="modelValue"
    @keypress.enter="$emit('update:modelValue', $event.target.value)"
    class="bg-slate-50 shadow-2xl shadow-black-500/50 rounded-full w-48 h-12 mt-6 p-5"
    required
    maxlength="15"
  />
</template>

<script setup>
defineProps(["modelValue"]);
defineEmits(["update:modelValue"]);
</script>
