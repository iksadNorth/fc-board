<template>
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
</template>

<script>
export default {
    data() {
        return {
            cols: [
                {name: '제목', width: '55%'}, 
                {name: '해시태그', width: '15%'}, 
                {name: '작성자', width: '15%'}, 
                {name: '작성일', width: '15%'}, 
            ],
        }
    },

    methods: {    
        mkPostLink(id) {
            return '/posts/' + id
        }
    },

    props: {
        posts: Object,
    },

}
</script>
