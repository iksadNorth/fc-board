<template>
    <v-container class="d-flex">
        <v-btn class="ma-2 pa-2" @click="to('/')"
            >Home</v-btn>

        <v-btn class="ma-2 pa-2" @click="to('/posts/search-hashtag')" 
            v-if="pathname != '/posts/search-hashtag'"
            >Hashtags</v-btn>

        <v-spacer class="mr-auto" />

        <v-btn class="ma-2 pa-2" variant="outlined" @click="to('/login')"
            >Login</v-btn>

        <v-btn class="ma-2 pa-2 bg-yellow-darken-2" @click="to('/join')"
            >Sign-up</v-btn>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            pathname: ''
        }
    },

    methods: {
        to(uri) {
            this.$router.push(uri)
        },
    },

    watch: {
        $route() {
            this.pathname = window.location.pathname
        }
    },
}
</script>

<style>

</style>
