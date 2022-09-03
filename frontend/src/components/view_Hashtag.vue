<template>
    <v-container class="d-flex flex-column">
        <div class="d-flex flex-column justify-center">
            <h2>Hashtags</h2>

            <v-chip-group
                v-model="index_tag"
                active-class="primary--text"
            >
                <v-chip
                v-for="tag in tags" :key="tag"
                >{{ tag }}</v-chip>
            </v-chip-group>

            <v-divider class="my-5"></v-divider>
        </div>

        <div class="bg-grey mb-1">
            <com-List-posts :posts="posts" />
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
            index_tag: undefined,

            posts: [
                {title: '첫 게시물 제목', hashtag: '#red', useraccount: 'iksad', created_at: '2022-01-01', id: 0,},
                {title: '두 게시물 제목', hashtag: '#blue', useraccount: 'north', created_at: '2022-01-31', id: 1,},
            ],

            tags: [
                'Work',
                'Home Improvement',
                'Vacation',
                'Food',
                'Drawers',
                'Shopping',
                'Art',
                'Tech',
                'Creative Writing',
            ],
        }
    },

    methods: {
        changeHashtag(val) {
            console.log(val);
            // TODO: 해당 페이지 게시글 조회 api 호출.
        },
    },

    watch: {
        index_tag: function(val) {
            this.changeHashtag(val);
        }
    },

    created() {
        // TODO: 화면 초기화 시, tags 초기화. 해시태그 중복제거 후 가져온 리스트
    }
}
</script>

<style>

</style>
