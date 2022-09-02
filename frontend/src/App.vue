<template>
  <v-app>
    <v-layout>
      <v-app-bar color="header bg-black">
        <Header />
      </v-app-bar>

      <v-main class="bg-red-lighten-4">
        <router-view></router-view>	
      </v-main>
    </v-layout>

    <v-footer class="footer">
      <Footer />
    </v-footer>
  </v-app>
</template>

<script>
import Header from './components/com_Header.vue'
import Footer from './components/com_Footer.vue'

export default {
  name: 'App',

  components: {
    Header, Footer
  },

  data: () => ({
    //
  }),
}
</script>

<style>
  .footer {
    max-height: 50px;
  }
</style>
