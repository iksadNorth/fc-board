<template>
    <v-container>
        <v-row class="mb-10 text-center">
            <v-col>
                <v-text-field
                v-model="title"
                label="게시물 제목"
                ></v-text-field>
            </v-col>
        </v-row>

        <v-row class="mb-10">
            <v-col cols="7">
                <v-textarea
                v-model="content"
                label="게시물 내용"
                ></v-textarea>
            </v-col>

            <v-divider vertical="true"></v-divider>

            <v-col cols="3">
                <p class="mb-2">{{ this.useraccount.name }}</p>
                <p class="mb-2">{{ this.useraccount.email }}</p>
                <p class="mb-2">{{ this.useraccount.created_at }}</p>
            </v-col>
        </v-row>

        <v-row class="mb-10">
            <v-btn 
            class="mx-2 text-white bg-blue"
            @click="registerPost()"
            >등록</v-btn>
        </v-row>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            title: '',
            content: '',
            useraccount: {
                name: 'iksad', 
                email: 'iksadnorth@gmail.com', 
                created_at: '2022-01-15', 
            },
        }
    },

    methods: {
        setUserInfo() {
            // TODO: 해당 페이지 작성자 조회 api 호출.
        },

        registerPost() {
            this.$router.push("/");
        },
    },

    created() {
        // this.setUserInfo();
    },
    
}
</script>
