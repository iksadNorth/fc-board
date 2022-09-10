<template>
    <v-container class="d-flex flex-column">
        <div class="d-flex justify-center">
            <v-col cols="3">
                <v-select
                variant="outlined"

                v-model="key"
                :items="keys"
                ></v-select>
            </v-col>
            <v-col cols="5">
                <v-text-field 
                variant="outlined" label="검색어..."
                
                v-model="query"

                append-inner-icon="mdi-magnify"
                @click:append-inner="sendQuery(query)"
                ></v-text-field>
            </v-col>
        </div>

        <div class="bg-grey mb-1">
            <com-List-posts :posts="posts" />
        </div>

        <div class="mb-1 d-flex justify-end">
            <v-btn 
            class="mx-16 bg-blue" rounded="lg" color="white" variant="outlined" 
            @click="registPost"
            >글쓰기
            </v-btn>
        </div>

        <div class="mb-1">
            <com-pagination :pages="10" :total_visible="8" @page="changePage" />
        </div>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            keys: ['제목', '본문', '작성자'],
            key: '제목',
            query: '',

            posts: [
                {title: '첫 게시물 제목', hashtag: '#red', useraccount: 'iksad', created_at: '2022-01-01', id: 0,},
                {title: '두 게시물 제목', hashtag: '#blue', useraccount: 'north', created_at: '2022-01-31', id: 1,},
            ],
        }
    },

    methods: {
        sendQuery(query) {
            // TODO: 해당 쿼리에 대한 게시글 조회 api 호출.
            // const params = JSON.stringify({
            //     size: this.comments_in_a_page,
            //     page: query,
            //     sortBy: 'createdAt-desc',
            // });
            query
            this.$axios
            // .get('/api/posts' + this.id(), params)
            .get('/api/posts' + this.id())
            .then(res => {
                console.log(res.data);
                console.log("게시글 조회[registerComment()]");
                this.posts = res.data.posts
            })
            .catch(err => {
                console.log(err);
                console.log("게시글 조회 실패! [registerComment()]");
            });
        },

        registPost() {
            // TODO: 게시글 등록 api 호출.
            this.$router.push("/post-write");
        },

        changePage(newVal) {
            // TODO: 해당 페이지 게시글 조회 api 호출.
            const params = JSON.stringify({
                size: this.comments_in_a_page,
                page: newVal,
                sortBy: 'createdAt-desc',
            });

            this.$axios
            .get('/api/posts', params)
            .then(res => {
                console.log(res.data);
                console.log("게시글 조회[registerComment()]");
                this.posts = res.data.posts
            })
            .catch(err => {
                console.log(err);
                console.log("게시글 조회 실패! [registerComment()]");
            });
        },
    },

}

</script>