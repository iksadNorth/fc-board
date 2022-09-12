<template>
    <v-container>
        <v-row class="mb-10 text-center">
            <v-col>
                <h1>{{ this.title }}</h1>
            </v-col>
        </v-row>

        <v-row class="mb-10">
            <v-col cols="7">{{ this.content }}</v-col>

            <v-divider vertical="true"></v-divider>

            <v-col cols="3">
                <p class="mb-2">{{ this.useraccount.name }}</p>
                <p class="mb-2">{{ this.useraccount.email }}</p>
                <p class="mb-2">{{ this.useraccount.created_at }}</p>
            </v-col>
        </v-row>

        <v-row class="mb-10">
            <v-btn class="mx-2 text-white bg-green">수정</v-btn>
            <v-btn class="mx-2 text-white bg-red">삭제</v-btn>
        </v-row>

        <v-row class="mb-10">
            <v-col cols="9">
                <v-textarea
                v-model="textarea"
                class="mx-2"
                label="댓글 쓰기"
                rows="3"
                ></v-textarea>
            </v-col>
            <v-col cols=1>
                <v-btn class="bg-blue text-white"
                @click="registerComment(textarea)"
                >쓰기</v-btn>
            </v-col>
        </v-row>

        <v-row>
            <v-col cols="9">
                <v-row 
                v-for="comment in comments" :key="comment"
                class="mb-10">
                    <v-col cols="9">
                        <p><strong class="mr-4">{{ comment.name }}</strong>{{ comment.created_at }}</p>
                        <v-divider length=200px></v-divider>
                        <p>{{ comment.content }}</p>
                    </v-col>
                    <v-col>
                        <v-btn class="mx-2 text-white bg-green">수정</v-btn>
                        <v-btn class="mx-2 text-white bg-red">삭제</v-btn>
                    </v-col>
                    <v-divider class="my-2"></v-divider>
                </v-row>
                <v-row justify="center">
                    <com-pagination :pages="pages" :total_visible="total_visible" @page="changePage" />
                </v-row>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            comments_in_a_page: 5,
            pages: 10,
            total_visible: 5,

            textarea: undefined,
            comments: [
                {name: 'iksad', created_at: '2022-01-01', content: '첫 댓글'},
                {name: 'north', created_at: '2022-01-02', content: '두 번째 댓글'},
            ],

            title: '제목',
            content: '게시글',
            useraccount: {
                name: 'iksad', 
                email: 'iksadnorth@gmail.com', 
                created_at: '2022-01-15', 
            },
        }
    },

    methods: {
        registerComment(textarea) {
            // TODO: 댓글 등록 api 호출.
            const params = JSON.stringify({
                content: textarea,
            });

            this.$axios
            .post('/api/posts', params)
            .then(res => {
                console.log(res.data);
                console.log("댓글 등록[registerComment()] :" + textarea);
            })
            .catch(err => {
                console.log(err);
                console.log("댓글 등록 실패! [registerComment()]");
            });
        },

        changePage(val) {
            // TODO: 해당 페이지 댓글 조회 api 호출.
            const params = JSON.stringify({
                size: this.comments_in_a_page,
                page: val,
                sortBy: 'createdAt-desc',
            });

            this.$axios
            .get('/api/posts' + this.id() + '/comments', params)
            .then(res => {
                console.log(res.data);
                console.log("댓글 조회[registerComment()]");
                this.comments = res.data.content
            })
            .catch(err => {
                console.log(err);
                console.log("댓글 조회 실패! [registerComment()]");
            });
        },

        setPost() {
            // TODO: 해당 페이지 게시글 조회 api 호출.
            this.$axios
            .get('/api/posts' + this.id())
            .then(res => {
                console.log(res.data);
                console.log("게시글 조회[registerComment()]");
                this.content = res.data.content
            })
            .catch(err => {
                console.log(err);
                console.log("게시글 조회 실패! [registerComment()]");
            });
        },

        setUserInfo() {
            // TODO: 해당 페이지 작성자 조회 api 호출.
        },
    },

    created() {
        // this.setPost();
        // this.setUserInfo();
        // this.changePage(1);
    },

    computed: {
        id() {
            return this.$route.params.id;
        }
    },
}
</script>
