<template>
  <div class="p-6 space-y-4">
    <input type="text" @change="handleFileChange" />
    <button
      @click="uploadImage"
      class="bg-blue-500 text-white px-4 py-2 rounded"
    >
      업로드
    </button>
    <div v-if="imageUrl">
      <img :src="imageUrl" alt="uploaded" class="mt-4 max-w-xs" />
    </div>
  </div>
</template>

<script setup>
import { ref } from "vue";
import { storage } from "@/api/firebase";

const file = ref(null);
const imageUrl = ref("");

const handleFileChange = (e) => {
  file.value = e.target.files[0];
};

const uploadImage = () => {
  if (!file.value) {
    alert("파일을 선택하세요");
    return;
  }
  const storageRef = storage.ref();
  const fileRef = storageRef.child(file.value.name);

  fileRef
    .put(file.value)
    .then(() => fileRef.getDownloadURL())
    .then((url) => {
      imageUrl.value = url;
    })
    .catch((err) => {
      alert("업로드 실패:" + err.message);
    });
};
</script>
