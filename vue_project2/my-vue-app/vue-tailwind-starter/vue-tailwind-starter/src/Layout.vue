<template>
  <div class="flex flex-col min-h-screen">
    <header class="bg-gray-200 text-center p-4">공통 헤더</header>

    <main class="flex-1 p-4">
      <router-view />
    </main>
    <footer class="bg-gray-200 text-center p-4">공통 푸터</footer>
  </div>
</template>
