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
                @click:append-inner="sendQuery()"
                ></v-text-field>
            </v-col>
        </div>

        <div class="bg-grey mb-1">
            <v-table>
                <thead><tr>
                    <th class="text-left" :width=col.width
                        v-for="col in cols" :key="col"
                    ><strong>{{ col.name }}</strong></th>
                </tr></thead>
                <tbody><tr
                    v-for="post in posts" :key="post"
                >
                    <td><router-link :to="mkPostLink(post.id)">{{ post.title }}</router-link></td>
                    <td>{{ post.hashtag }}</td>
                    <td>{{ post.useraccount }}</td>
                    <td>{{ post.created_at }}</td>
                </tr></tbody>
            </v-table>
        </div>

        <div class="mb-1 d-flex justify-end">
            <v-btn 
            class="mx-16 bg-blue" rounded="lg" color="white" variant="outlined" 
            @click="registPost"
            >글쓰기
            </v-btn>
        </div>

        <div class="mb-1">
            <v-pagination
            v-model="page"
            :length="pages" :total-visible="total_visible"
            rounded="10"
            ></v-pagination>
        </div>
    </v-container>
</template>

<script>
export default {
    data() {
        return {
            page: 1,
            pages: 10,
            total_visible: 8,

            keys: ['제목', '본문', '작성자'],
            key: '제목',
            query: '',

            cols: [
                {name: '제목', width: '55%'}, 
                {name: '해시태그', width: '15%'}, 
                {name: '작성자', width: '15%'}, 
                {name: '작성일', width: '15%'}, 
            ],

            posts: [
                {title: '첫 게시물 제목', hashtag: '#red', useraccount: 'iksad', created_at: '2022-01-01', id: 0,},
                {title: '두 게시물 제목', hashtag: '#blue', useraccount: 'north', created_at: '2022-01-31', id: 1,},
            ],
        }
    },

    methods: {
        sendQuery() {
            // 쿼리를 보낼 함수.
        },

        registPost() {
            // 글 등록 함수.
        },

        changePage(newVal) {
            console.log(newVal);
            // 페이지가 바뀔 때, 작동하는 함수.
        },

        mkPostLink(id) {
            return '/posts/' + id
        }
    },

    watch: {
        'page': function (newVal) {
            this.changePage(newVal);
        },
    },

}

</script>