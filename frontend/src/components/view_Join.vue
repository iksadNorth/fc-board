<template>
    <v-container class="d-flex justify-center mt-10">
        <v-card 
        min-width="400"
        class="pa-5 align-center w-50">
            <v-row>
                <v-col>
                    <h1>Sign-Up</h1>
                </v-col>
            </v-row>
            <v-row 
            v-for="attr in queryList" :key="attr"
            class="w-100">
                <v-col>
                    <v-text-field 
                    v-model="attr.value" 
                    :label="attr.label" 
                    :prepend-icon="attr.icon"
                    ></v-text-field>
                </v-col>
            </v-row>
            <v-row class="d-flex justify-center pa-3 text-red">
                <strong>{{ messageError }}</strong>
            </v-row>
            <v-row>
                <v-col class="d-flex justify-end px-10">
                    <v-btn
                    @click="clickSubmit()"
                    >Submit</v-btn>
                </v-col>
            </v-row>
        </v-card>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            messageError: "",

            queryList: [
                {icon: "mdi-account", label: "ID", value: undefined},
                {icon: "mdi-email", label: "Email", value: undefined},
                {icon: "mdi-lock", label: "PW", value: undefined},
                {icon: "mdi-check", label: "PW Again", value: undefined},
            ],
        }
    },

    methods: {
        clickSubmit(){
            this.$router.push("/");
        },
    },
}
</script>

<style>

</style>
