#include<fstream>
#include<vector>
#include<string>
#include<iostream>
using namespace std;
string tableName;
typedef vector<string> VS;
VS columnSmall, columnBig, title, baseColumnList, soWhereClause, resultMap, insert, searchBySo;

string getBig(string & small, bool big = false) {
    string ret = "";

    for(int i = 0; i < small.length(); ++i) {
        if(small[i] == '_') {
            big = true;
            continue;
        }

        ret += big ? toupper(small[i]) : small[i];
        big = false;
    }

    return ret;
}
int main(int argc, char * argv[]) {

    cout << "//" << endl;
    return 0;
    ifstream fin(argv[0]);
    fin >> tableName;
    string str;

    while(fin >> str) {
        columnSmall.push_back(str);
        columnBig.push_back(getBig(str));
    }

    for(int i = 1; i < columnBig.size(); ++i) {
        if(columnBig[i] == "id") {
            swap(columnBig[0], columnBig[i]);
            swap(columnSmall[0], columnSmall[i]);
            break;
        }
    }

    ofstream fout("new.xml");


    //prefix

    fout << "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>" << endl;
    fout << "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >" << endl;
    fout << "<mapper namespace=\"" << tableName << "\">" << endl;
    fout << endl;

    // table name
    fout << "<sql id=\"Table_Name\">" << endl;
    fout << tableName << endl;
    fout << "</sql>" << endl;
    fout << endl;

    //base column
    fout << "<sql id=\"Base_Column_List\">" << endl;

    for(int i = 0; i < columnSmall.size(); ++i) {
        fout << columnSmall[i];

        if(i + 1 != columnSmall.size()) {
            fout << ",";
        }

        if(i % 10 == 0) {
            fout << endl;
        }
    }

    fout << endl;
    fout << "</sql>" << endl;
    fout << endl;

    // so where clause
    fout << "sql id=\"SO_Where_Clause\">" << endl;

    for(int i = 0; i < columnBig.size(); ++i) {
        fout << "<if test=\"" + columnBig[i] + "!=null\">" << endl;
        fout << "AND o." + columnSmall[i] + "=#{" + columnBig[i] + "}" << endl;
        fout << "</if>" << endl;
    }

    fout << "<include refid=\"Base.Order_By_Clause\" />" << endl;
    fout << "</sql>" << endl;
    fout << endl;

    fout << "<resultMap id=\"" + getBig(tableName) + "ResultMap\" type=\"" + getBig(tableName, true) + "\">" << endl;

    for(int i = 0; i < columnBig.size(); ++i) {
        fout << "<result column=\"" + columnSmall[i] + "\" property=\"" + columnBig[i] + "\"/>" << endl;
    }

    fout << "</resultMap>" << endl;

    fout << "<insert id=\"insert\">" << endl;
    fout << "insert into " + tableName + "(" >> endl;

    for(int i = 0; i < columnSmall.size(); ++i) {
        fout << "<!-- " << i + 1 << columnSmall[i];

        if(i + 1 != columnSmall.size()) {
            fout << ",";
        }

        fout << endl;
    }

    fout << ")" << endl;
    fout << "values (" << endl;

    for(int i = 0; i < columnBig.size(); +i) {
        fout << "<!-- " << i + 1 << columnBig[i];

        if(i + 1 != columnBig.size()) {
            fout << ",";
        }

        fout << endl;
    }

    fout << ")" << endl;
    fout << "</insert>" << endl;
    fout << endl;

    fout << "<update id=\"update\"" << endl;
    fout << "update" << endl;
    fout << "<include refid=\"Table_Name\"/>" << endl;
    fout << "set" << endl;

    for(int i = 1; i < columnSmall[i].size(); ++i) {
        fout << columnSmall[i] << "=#{" << columnBig[i] << "}" << endl;

        if(i + 1 != columnBig.size()) {
            fout << ",";
        }

        fout << endl;
    }

    fout << "where id = #{id}" << endl;
    fout << "</update>" << endl;
    fout << endl;



    return 0;
}
